;learn sin and cos
;By Jonathan Pittock
;skn3ac@msn.com
;www.acsv.net
;www.acoders.com

;#-note
;	When using the Sin/Cos functions, remember that the following
;	angle values, are equivilant to the following directions, in a 2d world
;
;	angle#=0
;		right
;	angle#=90
;		down
;	angle#=180
;		left
;	angle#=270
;		up
;
;#-note
;	Cos returns a horizontal ( in a 2d world ) vector/speed value
;	Sin returns a vertical ( in a 2d world ) vector/speed value
;
;#-note
;	The sin and cos functions will return float numbers ranging from..
;		-1.0 to 1.0
;	This value is directly linked to the direction of the angel passed to it.
;	For example:
;	using the chart above, say we want to use the RIGHT direction, that would be an angle of 0
;		Xspeed# = cos#(0) = 1
;		Yspeed# = sin#(0) = 0
;	Before you try and understand that, think in your head what the X speed, and Y speed
;	would be, if you wanted to move in a RIGHT direction.
;		Xspeed# = 1    ( x=x+1 is moving right )
;		Yspeed# = 0    ( y=y+0 is not moving vertical )
;
;#-note
;	To move faster in a given angle, or to get a larger version of your X,Y speeds
;	simply multiply by a second number.
;		Xspeed# = cos#(angle) * Multiplier#
;		Yspeed# = sin#(angle) * Multiplier#

;Below are some demos of various uses for sin/cos

Graphics 400,400,32,2
SetBuffer BackBuffer()


;#-demo1
;rotate around a center x,y position, at variable distance
angle#=0

pointx#=0
pointy#=0

centerx#=200
centery#=200
distance#=70
Repeat
	Cls
		;get numpad +/- input to change size
		If KeyDown(74) And distance#>0 distance#=distance#-1
		If KeyDown(78) And distance#<150 distance#=distance#+1
			
		;Update using the sin/cos functions
		pointx# = centerx# + ( Cos#(angle#) * distance# )
		pointy# = centery# + ( Sin#(angle#) * distance# )
		
		;draw a simple graphic to show the center point
		Color 255,255,255
		Oval centerx#-5,centery#-5,10,10,1
		
		;draw a simple graphics to show the path the point is travelling
		Color 255,0,0
		Oval centerx#-(distance#),centery#-(distance#),distance#*2,distance#*2,0
		
		;draw a simple graphics to show the rotating point
		Color 255,255,255
		Oval pointx#-8,pointy#-8,16,16,1
		
		;update angle
		angle#=angle#+1
		If angle#=360 Then angle#=0
		
		;draw some status text
		Color 0,255,0
		Text 5,5,"DEMO: rotating around a center point"
		Color 255,255,255
		Text 5,20,"angle: "+angle#
		Text 5,35,"x speed: "+Cos#(angle#)
		Text 5,50,"y speed: "+Sin#(angle#)
		Color 255,0,0
		Text 5,65,"press space for next demo"
		Color 0,0,255
		Text 5,80,"use numpad +/- to change the size"
	Flip
Until KeyHit(57)

;#-demo2
;drawign a sine wave
i#=0
angle#=0

pointx#=0
pointy#=0

centerx#=200
centery#=200
multiplier#=70
frequency#=1
Repeat
	Cls
		;get u,d,l,r input
		If KeyDown(200) And distance#>0 multiplier#=multiplier#-1
		If KeyDown(208) And distance#<150 multiplier#=multiplier#+1
		If KeyDown(203) And distance#>0 frequency#=frequency#-0.1
		If KeyDown(205) frequency#=frequency#+0.1
		
		;draw sine wave
		Color 255,255,255
		i#=angle#
		For x=0 To 400
			Plot x,200+(Sin#(i#)*multiplier#)
			i#=i#+frequency#
		Next
		angle#=angle#+2
		
		;draw some status text
		Color 0,255,0
		Text 5,5,"DEMO: a sinewave"
		Color 255,0,0
		Text 5,20,"press space for next demo"
		Color 0,0,255
		Text 5,35,"use u,d keys to change amplitude"
		Text 5,50,"use l,r keys To change frequency"
	Flip
Until KeyHit(57)

;#-demo3
;360 degree movement
angle#=0

pointx#=200
pointy#=200

xspeed#=0
yspeed#=0

Repeat
	Cls
		;update x,y speeds
		xspeed#=Cos#(angle#)
		yspeed#=Sin#(angle#)
		
		;get input from u,d,l,r to move point
		If KeyDown(200)
			;move forwards
			pointx#=pointx#+xspeed#
			pointy#=pointy#+yspeed#
		End If
		If KeyDown(208)
			;move backwards
			pointx#=pointx#-xspeed#
			pointy#=pointy#-yspeed#
		End If
		If KeyDown(203)
			;turn left
			angle#=angle#-1
			If angle#=-1 angle#=359
		End If
		If KeyDown(205)
			;turn right
			angle#=angle#+1
			If angle#=360 angle#=0
		End If
		
		;draw a simple graphics to show the moving point
		Color 255,255,255
		Oval pointx#-20,pointy#-20,40,40,0
		;draw a simple graphics to show the direction of the point
		Color 255,0,0
		Line pointx#,pointy#,pointx#+(xspeed#*20),pointy#+(yspeed#*20)
		
		;draw some status text
		Color 0,255,0
		Text 5,5,"DEMO: moving in 360 degrees"
		Color 255,255,255
		Text 5,20,"angle: "+angle#
		Text 5,35,"x speed: "+Cos#(angle#)
		Text 5,50,"y speed: "+Sin#(angle#)
		Color 255,0,0
		Text 5,65,"press space to exit"
		Color 0,0,255
		Text 5,80,"use u,d keys to move l,r keys to turn"
	Flip
Until KeyHit(57)


