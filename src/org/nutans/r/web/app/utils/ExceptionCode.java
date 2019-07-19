package org.nutans.r.web.app.utils;

public enum ExceptionCode {

	Unable_to_create_fare_card(1000),
	No_records_in_the_card_list(1001),
	No_record_or_invalid_card_number_in_the_card_list(1002),
	Unable_to_save_the_object(1003),
	source_and_destination_same_location(1004);

	int code=0;
	
	ExceptionCode(int code)
	{
		this.code=code;
	}

	public int getCode() {
		return code;
	}
}
class ss
{
	public static void main(String[] args) {
		System.out.println(ExceptionCode.Unable_to_create_fare_card.getCode());
	}
}
