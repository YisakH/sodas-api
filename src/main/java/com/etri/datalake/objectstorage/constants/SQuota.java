package com.etri.datalake.objectstorage.constants;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;

/*
    TODO: 값 유효성 검사 필요
 */
@Schema(description = "할당량")
@Data
@Getter
public class SQuota {
    @Schema(description = "가능여부")
    private String enabled;

    @Schema(description = "최대로 넣을수 있는 오브젝트 수")
    private String max_objects;

    @Schema(description = "최대 KB 용량")
    private String max_size_kb;

    @Schema(description = "할당 타입")
    private String quota_type;

    public SQuota(String enabled, String max_objects, String max_size_kb, String quota_type) {
        this.enabled = enabled;
        this.max_objects = max_objects;
        this.max_size_kb = max_size_kb;
        this.quota_type = quota_type;
    }
}
