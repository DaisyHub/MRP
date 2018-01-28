package com.edu118.vo;

/**
 * 给页面返回结果的对象
 */
public class DataResult<V> {
	//错误信息
	private String message;
	
	//请求的结果状态
	private boolean state;
	
	//返回的数据对象
	private V data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public V getData() {
		return data;
	}

	public void setData(V data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "DataResult [message=" + message + ", state=" + state + ", data=" + data + "]";
	}
}
