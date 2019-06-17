package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot {
	private int 	position;
	private Color 	color;
	private int 	number;
	
	public SlotImpl(int position, Color color, int number) {
		this.position = position;
		this.color = color;
		this.number = number;
	}
	
	@Override
	public int getPosition() {
		return position;
	}

	@Override
	public int getNumber() {
		return number;
	}

	@Override
	public Color getColor() {
		return color;
	}

	public String toString() {
		String output = String.format("Position: %d, Color: %s, Number: %d",
				this.position, color.toString(), this.number);
		return output;
	}
	
	@Override
	public boolean equals(Slot slot) {
	    return (this.position == slot.getPosition() &&
	    		this.color    == slot.getColor() &&
	    		this.number   == slot.getNumber()
	    		);
	}

}
