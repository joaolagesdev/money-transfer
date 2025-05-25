package com.international.money.transfer.infrastructure.http;

import com.international.money.transfer.infrastructure.dtos.DollarQuotationResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
public class BcbServiceImpl implements BcbService {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public BigDecimal getDollarQuotationByDate(String date) {
    String url = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/" +
        "CotacaoDolarDia(dataCotacao=@dataCotacao)" +
        "?@dataCotacao='" + date + "'" +
        "&$top=100&$format=json&$select=cotacaoCompra";

    DollarQuotationResponseDto response = restTemplate.getForObject(url, DollarQuotationResponseDto.class);

    if (response != null && !response.purchaseRates().isEmpty()) {
      return response.purchaseRates().getFirst().purchaseRate();
    } else {
      throw new NoSuchElementException("No data available for date: " + date);
    }
  }
}
