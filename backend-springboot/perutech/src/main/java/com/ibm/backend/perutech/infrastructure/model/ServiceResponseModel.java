package com.ibm.backend.perutech.infrastructure.model;

import lombok.Data;
import java.util.List;

@Data
public class ServiceResponseModel {
    Boolean success;
    Boolean records;
    String message;
    String token;
    List<?> dataListModel;
    Object dataModel;
}
