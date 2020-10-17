package model.entities;

public class Components {
	
	private Integer id;
	private Integer quantity;
	private String description;
	private String code;
	private String provider1;
	private String provider2;
	
	private Machine machine;

	public Components() {
		
	}
	
	public Components(Integer id, Integer quantity, String description, String code, String provider1, String provider2,
			Machine machine) {
		this.id = id;
		this.quantity = quantity;
		this.description = description;
		this.code = code;
		this.provider1 = provider1;
		this.provider2 = provider2;
		this.machine = machine;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProvider1() {
		return provider1;
	}

	public void setProvider1(String provider1) {
		this.provider1 = provider1;
	}

	public String getProvider2() {
		return provider2;
	}

	public void setProvider2(String provider2) {
		this.provider2 = provider2;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((machine == null) ? 0 : machine.hashCode());
		result = prime * result + ((provider1 == null) ? 0 : provider1.hashCode());
		result = prime * result + ((provider2 == null) ? 0 : provider2.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Components other = (Components) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (machine == null) {
			if (other.machine != null)
				return false;
		} else if (!machine.equals(other.machine))
			return false;
		if (provider1 == null) {
			if (other.provider1 != null)
				return false;
		} else if (!provider1.equals(other.provider1))
			return false;
		if (provider2 == null) {
			if (other.provider2 != null)
				return false;
		} else if (!provider2.equals(other.provider2))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Components [id=" + id + ", quantity=" + quantity + ", description=" + description + ", code=" + code
				+ ", provider1=" + provider1 + ", provider2=" + provider2 + ", machine=" + machine + "]";
	}
	
}
