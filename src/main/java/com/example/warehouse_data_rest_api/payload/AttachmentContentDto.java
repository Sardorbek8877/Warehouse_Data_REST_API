package com.example.warehouse_data_rest_api.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentContentDto {

    private double bytes;

    private Integer attachmentId;
}
