package io.github.dflasso.transactions.models.dtos;

import lombok.Data;

/**
 * Wrapper to response APIs
 * @author dany lasso
 * @param <H> Header of response
 * @param <P> Payload of response
 */
@Data
public class ResponseDTO<H, P> {
    private H header;

    private P payload;
}
