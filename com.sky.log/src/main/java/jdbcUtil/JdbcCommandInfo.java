package jdbcUtil;

public class JdbcCommandInfo {
    private String sql;
    public String getSql() {
        return sql;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }

    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    
	private String memo; // 备注信息
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	private String module; // 模
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	@Override
	public String toString() {
		return "JdbcCommandInfo [memo=" + memo + ", data=" + data + ", sql=" + sql + ", module=" + module + "]";
	}

}
