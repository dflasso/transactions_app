package io.github.dflasso.transactions.exceptions;

import io.github.dflasso.transactions.models.dtos.ApiError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;

/**
 * Excepciones lanzadas en ejecución al no encontrar los datos solicitados
 * @author dlasso
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NotFoundException extends RuntimeException  {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    private ApiError apiError;
}
