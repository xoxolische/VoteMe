package com.voteme.model;

import java.sql.Timestamp;

public class Opinion {
	
	private long id;
	
	private String title;
	
	private String text;
	
	private Timestamp createdAt;
	
	private User author;
	
	private Versus versus;

}
