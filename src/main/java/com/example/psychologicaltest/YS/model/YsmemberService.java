package com.example.psychologicaltest.YS.model;

import com.example.psychologicaltest.YS.dto.YsmemberDTO;
import com.example.psychologicaltest.YS.dto.YsmemberPageRequestDTO;
import com.example.psychologicaltest.YS.dto.YsmemberPageResultDTO;
import com.example.psychologicaltest.YS.entity.Ysmember;
import com.example.psychologicaltest.YS.repository.YsmemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class YsmemberService implements YsmemberServiceInterface{

    private final YsmemberRepository ysmemberRepository;


    @Override
    public YsmemberPageResultDTO<YsmemberDTO, Ysmember> getList(YsmemberPageRequestDTO ysmemberPageRequestDTO) {

        Pageable pageable = ysmemberPageRequestDTO.getPageable(Sort.by("mid").descending());

        Page<Ysmember> result = ysmemberRepository.findAll(pageable);

        Function<Ysmember, YsmemberDTO> fn = (entity -> entityToDto(entity));

        return new YsmemberPageResultDTO<>(result, fn);
    }
}
