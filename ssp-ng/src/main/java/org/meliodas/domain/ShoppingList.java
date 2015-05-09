package org.meliodas.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data
public class ShoppingList {

	@Id
	private String id;

	private String name;

	private Date lastViewDate;

	private List<Item> items;

}
