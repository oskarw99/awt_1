package me.hsogge.awt_1.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import me.hsogge.awt_1.Main;
import me.hsogge.awt_1.world.entity.Enemy;
import me.hsogge.awt_1.world.entity.Mob;
import me.hsogge.awt_1.world.entity.Player;
import me.hsogge.awt_1.world.tile.Door;
import me.hsogge.awt_1.world.tile.Interactable;
import me.hsogge.awt_1.world.tile.Tile;

public class World {
	
	Player player;
	Enemy enemy;
	Enemy enemy2;
	List<GameObject> tiles = new ArrayList<>();
	List<Mob> mobs = new ArrayList<>();
	List<Enemy> enemies = new ArrayList<>();
	List<Interactable> interactables = new ArrayList<>();
	List<Rectangle> tileHitboxes = new ArrayList<>();
	Tile tile1;
	Tile tile2;
	Door door;
	
	public final int GRAVITY = 70 * 64;

	public World() {
		player = new Player("Player 1", this);
		enemy = new Enemy("Enemy 1", 13*32, -128, this);
		//enemy2 = new Enemy("Enemy 2", 14*32, -128, this);
		
		
		for (int i = 0; i < 40	; i++) {
			tiles.add(new Tile("blue", i, 0, this));
		}
		for (int i = 0; i < 13	; i++) {
			tiles.add(new Tile("green", 10+i, -5, this));
		}
		
		for (int i = 0; i < 4	; i++) {
			tiles.add(new Tile("yellow", 19, -i-1, this));
		}
		
		tiles.add(new Tile("yellow", 5, -1, this));
		tiles.add(new Tile("yellow", 6, -1, this));
		
		tiles.add(new Tile("green", 22, -1, this));
		tiles.add(new Tile("green", 23, -1, this));
		tiles.add(new Tile("green", 24, -1, this));
		
		door = new Door(10, -4, this);
		tiles.add(door);
	}

	public List<GameObject> getTiles() {
		return tiles;
	}
	
	public List<Interactable> getInteractables() {
		return interactables;
	}
	
	public List<Mob> getMobs() {
		return mobs;
	}
	
	public List<Enemy> getEnemies() {
		return enemies;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public List<Rectangle> getTileHitboxes() {
		return tileHitboxes;
	}
	
	

	public void tick() {
		player.tick();
		for (Enemy enemy : enemies) {
			enemy.tick();
			
		}

	}

	public void render(Graphics2D g) {
		g.setColor(new Color(18, 232, 184));
		g.fillRect(0, 0, Main.getCanvas().getWidth(), Main.getCanvas().getHeight());
		for (GameObject tile : tiles) {
			tile.render(g);
		}
		player.render(g);
		for (Enemy enemy : enemies) {
			enemy.render(g);
		}
		
	}
}
