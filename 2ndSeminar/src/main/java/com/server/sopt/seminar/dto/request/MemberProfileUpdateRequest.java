package com.server.sopt.seminar.dto.request;

import com.server.sopt.seminar.domain.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}