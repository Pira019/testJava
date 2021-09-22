package pira_exercice.java_Junit01;

import java.util.Date;

public class Movie {

	private String title;
	private Date releaseDate;
	
	@SuppressWarnings("unsed")
	private String duration;

	/**
	 * @param title
	 * @param releasDate
	 * @param duration
	 */
	public Movie(String title, Date releasDate, String duration) {
		super();
		this.title = title;
		this.releaseDate = releasDate;
		this.duration = duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movie other = (Movie) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public String getTitle() {
		return title;
	}

	public Date getReleasDate() {
		return releaseDate;
	}

	 
	
}
