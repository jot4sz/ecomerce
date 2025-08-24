package com.ecommerce.api.domain.mapper;

import com.ecommerce.api.domain.address.AddressEntity;
import com.ecommerce.api.domain.address.AddressRequestDTO;
import com.ecommerce.api.domain.address.AddressResponseDTO;
import com.ecommerce.api.domain.customer.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressEntity toEntity(AddressRequestDTO dto);

    @Mapping(target = "customer", source = "customer")
    @Mapping(target = "id", ignore = true)
    AddressEntity toEntity(AddressRequestDTO dto, CustomerEntity customer);

    AddressResponseDTO toDTO(AddressEntity address);

    List<AddressResponseDTO> toDTOList(List<AddressEntity> entities);

    void updateAddressFromDTO(AddressRequestDTO dto, @MappingTarget AddressEntity entity);
}
