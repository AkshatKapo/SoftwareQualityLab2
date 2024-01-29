package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class BinaryAPIController {

	@GetMapping("/add") // handles the get request sent to the URL /add
	public String addString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1, // RequestParam defines the ar
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  Binary.add(number1,number2).getValue();
		 //http: //localhost:8080/add?operand1=111&operand2=1010
	}
	
	@GetMapping("/add_json")
	public BinaryAPIResult addJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
                       @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
        return  new BinaryAPIResult(number1,"add",number2,Binary.add(number1,number2));
		//http://localhost:8080/add?operand1=111&operand2=1010
	}
	@GetMapping("/OR")
	public String ORString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
							@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  Binary.OR(number1,number2).getValue();
		 //http://localhost:8080/OR?operand1=111&operand2=1010
	}

	@GetMapping("/OR_json")
	public BinaryAPIResult ORJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
								   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  new BinaryAPIResult(number1,"OR",number2,Binary.OR(number1,number2));
		// http://localhost:8080/OR_json?operand1=111&operand2=1010
	}

	@GetMapping("/And")
	public String AndString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
						   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  Binary.And(number1,number2).getValue();
		//http://localhost:8080/And?operand1=111&operand2=1010
	}

	@GetMapping("/And_json")
	public BinaryAPIResult AndJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
								  @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  new BinaryAPIResult(number1,"And",number2,Binary.And(number1,number2));
		 //http://localhost:8080/And?operand1=111&operand2=1010
	}

	@GetMapping("/multiply")
	public String multiplyString(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
							@RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  Binary.multiply(number1,number2).getValue();
		//http://localhost:8080/multiply?operand1=111&operand2=1010
	}

	@GetMapping("/mulitply_json")
	public BinaryAPIResult multiplyJSON(@RequestParam(name="operand1", required=false, defaultValue="") String operand1,
								   @RequestParam(name="operand2", required=false, defaultValue="") String operand2) {
		Binary number1=new Binary (operand1);
		Binary number2=new Binary (operand2);
		return  new BinaryAPIResult(number1,"multiply",number2,Binary.multiply(number1,number2));
		//http://localhost:8080/multiply?operand1=111&operand2=1010
	}

}