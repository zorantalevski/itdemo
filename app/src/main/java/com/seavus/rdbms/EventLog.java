package com.seavus.rdbms;

import com.seavus.rdbms.validator.JsonField;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Zoran.Talevski
 */
@Entity(name = "eventlog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
// with json b
@TypeDefs({@TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)})
public class EventLog {
    @Id
    private long id;
    private String type;
    private String status;

//    with json b
    @Type(type = "jsonb")
    @Column(name = "raw_json", columnDefinition = "jsonb")
    @JsonField
    private String rawJson;

}
