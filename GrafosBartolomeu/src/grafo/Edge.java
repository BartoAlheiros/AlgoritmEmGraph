package grafo;

public class Edge {
	
	Integer x;
	Integer y;
	Integer weight;
	
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public boolean equals(Edge e) {
		
		boolean result = false;
		
		if(this.x.equals(e.getX()) && this.y.equals(e.getY())) {
			result = true;
		}
		
		return result;
	}
	
	public String toString() {
		return "(" + this.x + "," + this.y + ")" + "W = " + this.weight;
	}
}
