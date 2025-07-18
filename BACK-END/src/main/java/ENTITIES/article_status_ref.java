package ENTITIES;

public enum article_status_ref {
    new_with_tag,
    new_without_tag,
    very_good_condition,
    good_condition,
    satisfactory;
	   public static article_status_ref fromValue(String value) {
	        for (article_status_ref status : values()) {
	            if (status.name().equalsIgnoreCase(value)) {
	                return status;
	            }
	        }
	        throw new IllegalArgumentException("Invalid article status: " + value);
	    }
	   public static String toEnumString(Enum<?> value) {
		    return value.name().toLowerCase().replace('_', '-');
		}
	
}
