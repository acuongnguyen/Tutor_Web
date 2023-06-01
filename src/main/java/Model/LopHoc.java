package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LopHoc {
    private String idLH;
    private String tenLH;
    private Date lichhoc;
    private float hocphi;
    private String mota;
    private UserGS giaSu;
    private UserHS hocSinh;


    public LopHoc() {
    }

    public LopHoc(String idLH, String tenLH, Date lichhoc, float hocphi, String mota, UserGS giaSu) {
        this.idLH = idLH;
        this.tenLH = tenLH;
        this.lichhoc = lichhoc;
        this.hocphi = hocphi;
        this.mota = mota;
        this.giaSu = giaSu;
    }

    public UserHS getHocSinh() {
		return hocSinh;
	}

	public void setHocSinh(UserHS hocSinh) {
		this.hocSinh = hocSinh;
	}

	public String getIdLH() {
        return idLH;
    }

    public void setIdLH(String idLH) {
        this.idLH = idLH;
    }

    public String getTenLH() {
        return tenLH;
    }

    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public Date getLichhoc() {
        return lichhoc;
    }

    public void setLichhoc(Date lichhoc) {
        this.lichhoc = lichhoc;
    }

    public float getHocphi() {
        return hocphi;
    }

    public void setHocphi(float hocphi) {
        this.hocphi = hocphi;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public UserGS getGiaSu() {
        return giaSu;
    }

    public void setGiaSu(UserGS giaSu) {
        this.giaSu = giaSu;
    }

    public String getDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(lichhoc);
    }

    public int countHV;
}