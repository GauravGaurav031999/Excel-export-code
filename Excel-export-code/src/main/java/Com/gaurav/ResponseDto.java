package Com.gaurav;

import org.springframework.stereotype.Service;

@Service
public class ResponseDto {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
