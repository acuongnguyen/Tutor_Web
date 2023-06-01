package Model;

public class UserHS {
    private int idHS;
    private String tenHS;
    private String gioitinh;
    private String diachi;
    private String sdt;
    private String email;
    private String stk;
    private TaiKhoan account;

    public UserHS() {
    }

    public UserHS(int idHS, String tenHS, String gioitinh, String diachi, String sdt, String email, String stk, TaiKhoan account) {
        this.idHS = idHS;
        this.tenHS = tenHS;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        this.stk = stk;
        this.account = account;
    }

    public int getIdHS() {
        return idHS;
    }

    public void setIdHS(int idHS) {
        this.idHS = idHS;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public TaiKhoan getAccount() {
        return account;
    }

    public void setAccount(TaiKhoan account) {
        this.account = account;
    }
}