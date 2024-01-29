package com.antevgproject.neighbornest.domain.association;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Association}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveAssociationsDto implements Serializable {
    private Integer id;
    @NotNull
    @Size(max = 255)
    private String name;
}