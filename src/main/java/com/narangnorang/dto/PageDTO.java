package com.narangnorang.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("PageDTO")
public class PageDTO<E> {

	private int limit; // 한 페이지당 보여줄 행 개수
	private int currentPage; // 현재 페이지 번호
	private int totalRows; // 전체 행 개수
	private List<E> rowList; // 현재 페이지에 보여줄 행 리스트

}
