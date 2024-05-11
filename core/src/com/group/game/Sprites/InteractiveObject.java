package com.group.game.Sprites;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.group.game.RunGame;


public abstract class InteractiveObject {
    protected World world;
    protected TiledMap map;
    protected TiledMapTile tile;

    protected Rectangle bounds;
    protected Body body;
    protected  Fixture fixture;

    public InteractiveObject(World world, TiledMap map, Rectangle bounds){
        this.world = world;
        this.map = map;
        this.bounds = bounds;

        BodyDef bdef = new BodyDef();
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();

        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set((bounds.getX() + bounds.getWidth() / 2) / RunGame.RSF, (bounds.getY() + bounds.getHeight() / 2) / RunGame.RSF);

        body = world.createBody(bdef);

        shape.setAsBox(bounds.getWidth() / 2 / RunGame.RSF, bounds.getHeight() / 2 / RunGame.RSF);
        fdef.shape = shape;
        fixture = body.createFixture(fdef);
    }

    public abstract void onHeadHit();
