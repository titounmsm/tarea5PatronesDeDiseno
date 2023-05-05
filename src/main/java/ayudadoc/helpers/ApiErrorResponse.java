package ayudadoc.helpers;

import org.springframework.http.HttpStatus;


public class ApiErrorResponse {

  private String type;
  private String title;
  private int status;
  private String detail;
  private String instance;

  public ApiErrorResponse() {
  }

  public ApiErrorResponse(String type, String title, HttpStatus status, String detail, String instance) {
    this.type = type;
    this.title = title;
    this.status = status.value();
    this.detail = detail;
    this.instance = instance;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status.value();
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public String getInstance() {
    return instance;
  }

  public void setInstance(String instance) {
    this.instance = instance;
  }
}
