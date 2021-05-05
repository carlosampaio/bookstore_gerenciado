package com.sampaio.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sampaio.bookstore.dto.BookDTO;
import com.sampaio.bookstore.entity.Book;

@Mapper
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
	// SourceTargetMapper MAPPER = Mappers.getMapper( SourceTargetMapper.class );
	//  @Mapping( source = "test", target = "testing" )
	//    Target toTarget( Source s );
	
	Book toModeL(BookDTO booKDTO);
	BookDTO toDTO(Book booK);
	
	
}
