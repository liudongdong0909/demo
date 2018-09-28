package com.example.demo.future;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DailyClientRecon {

    private Integer sn;

    private Integer clientSn;

    private LocalDate reconDate;

    private BigDecimal todayCashBalance;

    private BigDecimal todayCashIncreasement;

    private BigDecimal yesterdayBalance;

    private Integer status;

    private String exchangeCode;

    private String assetAccountCode;

    public DailyClientRecon(Integer sn, Integer clientSn, LocalDate reconDate, BigDecimal todayCashBalance, BigDecimal todayCashIncreasement, BigDecimal yesterdayBalance, Integer status, String exchangeCode, String assetAccountCode) {
        this.sn = sn;
        this.clientSn = clientSn;
        this.reconDate = reconDate;
        this.todayCashBalance = todayCashBalance;
        this.todayCashIncreasement = todayCashIncreasement;
        this.yesterdayBalance = yesterdayBalance;
        this.status = status;
        this.exchangeCode = exchangeCode;
        this.assetAccountCode = assetAccountCode;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Integer getClientSn() {
        return clientSn;
    }

    public void setClientSn(Integer clientSn) {
        this.clientSn = clientSn;
    }

    public LocalDate getReconDate() {
        return reconDate;
    }

    public void setReconDate(LocalDate reconDate) {
        this.reconDate = reconDate;
    }

    public BigDecimal getTodayCashBalance() {
        return todayCashBalance;
    }

    public void setTodayCashBalance(BigDecimal todayCashBalance) {
        this.todayCashBalance = todayCashBalance;
    }

    public BigDecimal getTodayCashIncreasement() {
        return todayCashIncreasement;
    }

    public void setTodayCashIncreasement(BigDecimal todayCashIncreasement) {
        this.todayCashIncreasement = todayCashIncreasement;
    }

    public BigDecimal getYesterdayBalance() {
        return yesterdayBalance;
    }

    public void setYesterdayBalance(BigDecimal yesterdayBalance) {
        this.yesterdayBalance = yesterdayBalance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExchangeCode() {
        return exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getAssetAccountCode() {
        return assetAccountCode;
    }

    public void setAssetAccountCode(String assetAccountCode) {
        this.assetAccountCode = assetAccountCode;
    }
}
