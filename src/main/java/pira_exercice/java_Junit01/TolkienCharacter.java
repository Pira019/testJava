package pira_exercice.java_Junit01;

public class TolkienCharacter {
	
	public int age;
	private String name;
	private Race race;
	
	@SuppressWarnings("unsend")
	private long notAccessibleField = System.currentTimeMillis();

	/**
	 * @param age
	 * @param name
	 * @param race
	 */
	public TolkienCharacter( String name,int age, Race race) {
		super();
		this.age = age;
		this.name = name;
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age <0) {
			throw new IllegalArgumentException("Age is not allowed to be smaller");
		}
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public long getNotAccessibleField() {
		return notAccessibleField;
	}

	public void setNotAccessibleField(long notAccessibleField) {
		this.notAccessibleField = notAccessibleField;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (notAccessibleField ^ (notAccessibleField >>> 32));
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TolkienCharacter other = (TolkienCharacter) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (notAccessibleField != other.notAccessibleField)
			return false;
		if (race != other.race)
			return false;
		return true;
	}

	@Override
    public String toString() {
        return name + " " + age + " years old " + race.getName();
    }
	

}
