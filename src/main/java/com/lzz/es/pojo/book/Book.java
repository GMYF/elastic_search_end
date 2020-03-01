package com.lzz.es.pojo.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author 李振振
 * @version 1.0
 * @date 2020/3/1 16:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "book",type = "auditindex")
public class Book {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Integer)
    private Integer age;
    private String date;
}
