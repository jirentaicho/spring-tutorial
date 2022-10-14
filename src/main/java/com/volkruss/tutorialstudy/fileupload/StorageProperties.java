package com.volkruss.tutorialstudy.fileupload;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * アクセサーは必要
 *
 */
@Getter
@Setter
@Component
@ConfigurationProperties("storage")
public class StorageProperties {
    //　resourcesフォルダにstorageフォルダを作成しておきます
    private String location = "src/main/resources/storage";
}
