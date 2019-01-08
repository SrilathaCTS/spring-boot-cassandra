package com.cts.cassandra.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table 
public class Employee {

	 @PrimaryKey
		private int id;
		private String firstname;
		private String lastname;
		private String dept;
		
		public Employee() { 
		}
		
		public Employee(int id, String firstname, String lastname, String dept) {
			super();
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.dept = dept;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Employee [id=");
			builder.append(id);
			builder.append(", firstname=");
			builder.append(firstname);
			builder.append(", lastname=");
			builder.append(lastname);
			builder.append(", dept=");
			builder.append(dept);
			builder.append("]");
			return builder.toString();
		}
		
		
}
