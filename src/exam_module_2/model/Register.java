package exam_module_2.model;

public class Register {
    private String registerNumber;
    private String nameOfOwn;
    private String code;
    private String registerDate;

    public Register() {
    }

    public Register(String registerNumber, String nameOfOwn, String code, String registerDate) {
        this.registerNumber = registerNumber;
        this.nameOfOwn = nameOfOwn;
        this.code = code;
        this.registerDate = registerDate;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getNameOfOwn() {
        return nameOfOwn;
    }

    public void setNameOfOwn(String nameOfOwn) {
        this.nameOfOwn = nameOfOwn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s", this.getRegisterNumber(), this.getNameOfOwn(), this.getCode(),
                this.getRegisterDate());
    }
}
