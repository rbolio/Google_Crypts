package pojos;

import java.math.BigDecimal;
import java.util.Date;

import com.bitso.helpers.Helpers;

public class BitsoBean {
	private BigDecimal last;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal vwap;
	private BigDecimal volume;
	private BigDecimal bid;
	private BigDecimal ask;
	private Date createdAt;
	public BigDecimal getLast() {
		return last;
	}
	public void setLast(BigDecimal last) {
		this.last = last;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getVwap() {
		return vwap;
	}
	public void setVwap(BigDecimal vwap) {
		this.vwap = vwap;
	}
	public BigDecimal getVolume() {
		return volume;
	}
	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}
	public BigDecimal getBid() {
		return bid;
	}
	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}
	public BigDecimal getAsk() {
		return ask;
	}
	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "BitsoBean (USD) [last=" + last + ", high=" + high + ", low=" + low + ", vwap=" + vwap + ", volume=" + volume
				+ ", bid=" + bid + ", ask=" + ask + ", createdAt=" + createdAt + "]";
	}
	public BitsoBean(BigDecimal last, BigDecimal high, BigDecimal low, BigDecimal vwap, BigDecimal volume,
			BigDecimal bid, BigDecimal ask, Date createdAt) {
		super();
		this.last = last;
		this.high = high;
		this.low = low;
		this.vwap = vwap;
		this.volume = volume;
		this.bid = bid;
		this.ask = ask;
		this.createdAt = createdAt;
	}
	public BitsoBean() {
		super();
	}
	
	

}
