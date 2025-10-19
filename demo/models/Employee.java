package demo.models;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int emp_id;

	private String emp_name;

	private int emp_age;

	private int salary;

}
