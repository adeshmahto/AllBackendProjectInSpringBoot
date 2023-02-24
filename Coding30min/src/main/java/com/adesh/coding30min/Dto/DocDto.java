package com.adesh.coding30min.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DocDto {
	private Integer id;
	private String docName;
	private String docType;
	private byte[] data;
}
