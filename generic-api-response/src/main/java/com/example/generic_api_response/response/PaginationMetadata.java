package com.example.generic_api_response.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationMetadata {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
