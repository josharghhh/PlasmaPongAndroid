package com.teamwut.plasma.plasmapong.pong.objects;

import processing.core.PApplet;
import processing.core.PImage;

import com.teamwut.plasma.plasmapong.pong.Const;
import com.teamwut.plasma.plasmapong.pong.Drawbl;

public class Goals {
	final PApplet p;

	final float width;
	final float height;

	int goalBoarder = 80;
	int goalColor;

	PImage top;
	PImage bottom;
	PImage middle;
	
	public Goals(final PApplet p) {
		this.p = p;
		this.width = p.width;
		this.height = p.height;
		goalColor = p.color(150, 150, 150, 150);
		
		top = Drawbl.getGoalTop(p);
		bottom = Drawbl.getGoalBottom(p);
		middle = Drawbl.getGoalMiddle(p);
	}

	public void draw(final PApplet p) {
		// for now
//		p.stroke(goalColor);
//		p.strokeWeight(3);
//		p.line(goalBoarder, goalBoarder, goalBoarder, height - goalBoarder);
//		p.line(width - goalBoarder, goalBoarder, width - goalBoarder, height
//				- goalBoarder);
		p.imageMode(PApplet.CORNER);
		p.image(top, 0, 0);
		p.image(bottom, p.width-bottom.width, p.height-bottom.height);
		p.imageMode(PApplet.CENTER);
		p.image(middle, width/2, height/2);
		p.imageMode(PApplet.CORNER);
	}
	
	
	
	public int puckGoalStatus(final Ball b) {
		if (b.y < goalBoarder) {
			return Const.PLAYER_1;
		} else if (b.y > height - goalBoarder) {
			return Const.PLAYER_2;
		} else {
			return Const.NO_PLAYER;
		}
	}
	
}
