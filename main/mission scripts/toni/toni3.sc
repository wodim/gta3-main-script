MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Toni mission 3****************************************
// *************************************Pick up the Lads**************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_toni3

IF has_deatharrest_been_executed
	GOSUB mission_toni3_failed
ENDIF

GOSUB mission_cleanup_toni3

MISSION_END

// Variables for mission

VAR_INT carry_car blip1_t3 blip2_t3 blip3_t3 blip4_t3 blip5_t3 cutscene_seen_flag

VAR_INT flag_displayed_horn_message_tm3 flag_displayed_wanted_message_tm3 flag_car_blip_displayed

VAR_INT triads1 triads2 triads3 triads4 triads5 triads6 triads7 triads8 triads9 triads10 //triads11 triads12  

VAR_INT triad_van1 triad_van2 triad_van3 triad_van4	triad_van5 triad_van6

// ***************************************Mission Start*************************************

mission_start_toni3:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
flag_player_on_toni_mission = 1
SCRIPT_NAME toni3
CLEAR_THIS_BIG_PRINT (M_PASS)
WAIT 0

cutscene_seen_flag = 0

/*
IF CAN_PLAYER_START_MISSION Player
	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player
ELSE
	GOTO mission_toni3_failed
ENDIF

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

SWITCH_STREAMING OFF

PRINT_BIG ( TM3 ) 15000 2 //"Toni Mission 1"	 
*/

{

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2	NOTE
REQUEST_MODEL ind_newrizzos

/*
WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE
*/

//LOAD_SCENE 1218.4 -314.5 28.9

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED ind_newrizzos
	WAIT 0

ENDWHILE

LOAD_CUTSCENE T3_MAS
SET_CUTSCENE_OFFSET 1218.42 -314.5 28.9
					
CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_OBJECT cut_obj2 cs_note
SET_CUTSCENE_ANIM cs_note NOTE

CLEAR_AREA 1219.5 -321.1 27.5 1.0 TRUE
SET_PLAYER_COORDINATES player 1219.5 -321.1 26.4

SET_PLAYER_HEADING player 180.0

CLEAR_AREA 1216.1 -313.0 29.9 10.0 TRUE	//TONIS RESTAURANT

DO_FADE 1500 FADE_IN

//SWITCH_WORLD_PROCESSING OFF
SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time

/*
WHILE cs_time < 100
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_MA ) 5000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 1000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_MB ) 5000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 2000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_MC ) 5000 1 // Pick Frankies Limo at Joeys and take it to him
*/
WHILE cs_time < 3006
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_A ) 10000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 5297
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_B ) 10000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 8661
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_C ) 10000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 12025
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_D ) 10000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 14817
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_E ) 10000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 17107 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_F ) 10000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 18968
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TM3_G ) 10000 1 // Pick Frankies Limo at Joeys and take it to him

WHILE cs_time < 19787
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 21666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE


DO_FADE 1500 FADE_OUT

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0

ENDWHILE

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

//SWITCH_WORLD_PROCESSING ON
SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

WAIT 500

DO_FADE 1500 FADE_IN

MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ1
MARK_MODEL_AS_NO_LONGER_NEEDED CUT_OBJ2
MARK_MODEL_AS_NO_LONGER_NEEDED ind_newrizzos

// START OF MISSION

LOAD_SPECIAL_CHARACTER 1 tony
LOAD_SPECIAL_CHARACTER 2 joey2
LOAD_SPECIAL_CHARACTER 3 luigi

REQUEST_MODEL CAR_STRETCH
REQUEST_MODEL CAR_BELLYUP
REQUEST_MODEL PED_GANG_TRIAD_A
REQUEST_MODEL PED_GANG_TRIAD_B

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CAR_STRETCH
OR NOT HAS_MODEL_LOADED	CAR_BELLYUP
OR NOT HAS_MODEL_LOADED PED_GANG_TRIAD_A
OR NOT HAS_MODEL_LOADED	PED_GANG_TRIAD_B
	WAIT 0
ENDWHILE
/*
WHILE NOT ROTATE_OBJECT joeys_garage_door3 135.0 30.0 FALSE
	WAIT 0

ENDWHILE
*/
CREATE_CAR CAR_STRETCH 1187.0 -860.4 14.5 carry_car
SET_CAR_HEADING carry_car 225.0
CHANGE_CAR_COLOUR carry_car CARCOLOUR_BLACK CARCOLOUR_BLACK
SET_CAR_STRONG carry_car TRUE
SET_CAR_PROOFS carry_car TRUE TRUE TRUE TRUE TRUE
//ADD_BLIP_FOR_CAR carry_car blip1_t3
ADD_BLIP_FOR_COORD 1191.7 -870.0 -100.0	blip1_t3
SET_CAN_RESPRAY_CAR carry_car OFF
//SET_RADIO_CHANNEL carry_car 1 -1

//PICK UP LIMO AND JOEY

//GOTO skip_to_toni3_cut //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

pick_up_joey:

	flag_car_blip_displayed = TRUE

	IF IS_CAR_DEAD carry_car
		GOTO mission_toni3_failed
	ENDIF


WHILE NOT LOCATE_PLAYER_ON_FOOT_3D Player 1191.7 -870.0 15.0 1.5 1.5 2.0 TRUE
	WAIT 0

	IF IS_CAR_DEAD carry_car
		GOTO mission_toni3_failed
	ENDIF

ENDWHILE


	SET_PLAYER_CONTROL Player Off
	SET_POLICE_IGNORE_PLAYER Player On
	SET_EVERYONE_IGNORE_PLAYER Player ON
	SWITCH_WIDESCREEN ON		
	SET_FADING_COLOUR 0 0 0
	DO_FADE 1000 FADE_OUT
	 
	WAIT 1000
	LOAD_SCENE 1190.07 -869.86 13.97

	IF IS_PLAYER_PLAYING Player

	   	CLEAR_AREA 1190.2 -866.4 14.1 1.0 TRUE
	   	SET_PLAYER_COORDINATES player 1189.5 -867.6 14.1
		SET_PLAYER_HEADING player 36.0	
		SET_FIXED_CAMERA_POSITION 1186.177 -852.455 17.219 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 1186.077 -853.425 16.995 JUMP_CUT
		GET_PLAYER_CHAR Player script_controlled_player
		SET_CHAR_RUNNING script_controlled_player TRUE
		IF NOT IS_CAR_DEAD carry_car
			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER script_controlled_player carry_car
		ENDIF

		DO_FADE 1000 FADE_IN
		WAIT 1000
	ENDIF

	IF IS_CAR_DEAD carry_car
	  	GOTO mission_toni3_failed
	ENDIF

	WHILE NOT IS_PLAYER_IN_CAR player carry_car	
		WAIT 0

			IF IS_CAR_DEAD carry_car
				GOTO mission_toni3_failed
			ENDIF

	ENDWHILE
/*
WHILE NOT ROTATE_OBJECT joeys_garage_door3 45.0 30.0 FALSE
	WAIT 0

ENDWHILE
*/
REMOVE_BLIP blip1_t3
SET_RADIO_CHANNEL 1 -1

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL2 1179.4 -858.6 14.0 joey
CLEAR_CHAR_THREAT_SEARCH joey

	IF IS_CAR_DEAD carry_car
		GOTO mission_toni3_failed
	ENDIF

SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER joey carry_car

//SET_FIXED_CAMERA_POSITION 1182.8 -856.1 17.0 0.0 0.0 0.0
//POINT_CAMERA_AT_CHAR joey FIXED INTERPOLATION

TIMERB = 0
LOAD_MISSION_AUDIO T3_A

	WHILE NOT IS_CHAR_IN_CAR joey carry_car 
		WAIT 0

		 	IF IS_CHAR_DEAD joey
				GOTO mission_toni3_failed
			ENDIF

			IF IS_CAR_DEAD carry_car
				GOTO mission_toni3_failed
			ENDIF

			IF TIMERB > 10000
				IF NOT IS_CHAR_DEAD	joey
				AND NOT IS_CAR_DEAD	carry_car
					//WARP_CHAR_INTO_CAR joey carry_car
					//WARP_CHAR_INTO_CAR_AS_PASSENGER joey carry_car
				ENDIF
			ENDIF

	ENDWHILE	

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO

SET_CHAR_CANT_BE_DRAGGED_OUT joey TRUE
ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 blip3_t3

//CAR DRIVING OUT OF GARAGE CUT SCENE

CLEAR_AREA 1195.0 -870.3 15.0 10.0 TRUE

SET_FIXED_CAMERA_POSITION 1200.9 -866.5 19.0 0.0 0.0 0.0
POINT_CAMERA_AT_PLAYER player FIXED JUMP_CUT

GET_OBJECT_COORDINATES joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z
GET_OBJECT_COORDINATES joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z

joeydoor2_Z = joeydoor2_Z + 3.0
joeydoor3_Z = joeydoor3_Z + 3.0

	WHILE NOT SLIDE_OBJECT joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z 0.1 0.1 0.1 FALSE
	OR NOT SLIDE_OBJECT joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z 0.1 0.1 0.1 FALSE

		WAIT 0

		IF IS_CAR_DEAD carry_car
			GOTO mission_toni3_failed
		ENDIF

	ENDWHILE

CAR_GOTO_COORDINATES_ACCURATE carry_car 1198.4 -871.1 -100.0
SET_CAR_CRUISE_SPEED carry_car 4.0
SET_CAR_DRIVING_STYLE carry_car 3

WHILE NOT LOCATE_CAR_2D carry_car 1198.4 -871.1 2.0 2.0 FALSE
	WAIT 0

	IF IS_CAR_DEAD carry_car
		GOTO mission_toni3_failed
	ENDIF

ENDWHILE

GET_OBJECT_COORDINATES joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z
GET_OBJECT_COORDINATES joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z

joeydoor2_Z = joeydoor2_Z - 3.0
joeydoor3_Z = joeydoor3_Z - 3.0

	WHILE NOT SLIDE_OBJECT joeys_garage_door2 joeydoor2_X joeydoor2_Y joeydoor2_Z 0.1 0.1 0.1 FALSE
	OR NOT SLIDE_OBJECT joeys_garage_door3 joeydoor3_X joeydoor3_Y joeydoor3_Z 0.1 0.1 0.1 FALSE
		WAIT 0

		IF IS_CAR_DEAD carry_car
			GOTO mission_toni3_failed
		ENDIF

	ENDWHILE

ADD_BLIP_FOR_CAR carry_car blip1_t3
REMOVE_BLIP blip1_t3

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL Player On
SET_CAR_STATUS carry_car STATUS_PLAYER
SET_POLICE_IGNORE_PLAYER Player Off
SET_EVERYONE_IGNORE_PLAYER Player OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_IN_FRONT_OF_PLAYER
SET_CAR_PROOFS carry_car FALSE FALSE FALSE FALSE FALSE
flag_displayed_horn_message_tm3 = 0
flag_displayed_wanted_message_tm3 = 0


//PICK UP LUIGI

REMOVE_BLIP blip3_t3

pick_up_Luigi:

IF IS_CAR_DEAD carry_car
	GOTO mission_toni3_failed
ENDIF

flag_car_blip_displayed = TRUE
blob_flag = 1

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_3D player 903.8 -423.0 14.0 908.3 -431.0 18.0 blob_flag
OR NOT IS_PLAYER_IN_CAR player carry_car
OR NOT IS_PLAYER_PRESSING_HORN player
OR IS_WANTED_LEVEL_GREATER Player 0    	

	WAIT 0

	IF IS_CAR_DEAD carry_car
		PRINT_NOW (TM3_A1) 5000 1 //Joeys dead
		GOTO mission_toni3_failed
	ENDIF
   
	IF IS_PLAYER_IN_CAR player carry_car
		IF flag_car_blip_displayed = TRUE
			ADD_BLIP_FOR_COORD 906.2 -426.0 -100.0 blip3_t3
			blob_flag = 1
			REMOVE_BLIP blip1_t3
		flag_car_blip_displayed = FALSE
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player carry_car
		IF flag_car_blip_displayed = FALSE
			ADD_BLIP_FOR_CAR carry_car blip1_t3
			REMOVE_BLIP blip3_t3
			blob_flag = 0
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the carry_car!"
			flag_car_blip_displayed = TRUE
		ENDIF
	ENDIF

	IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 903.8 -420.2 14.0 908.3 -431.1 18.0 FALSE
		IF IS_PLAYER_IN_CAR player carry_car
			IF IS_WANTED_LEVEL_GREATER player 0
				IF flag_displayed_wanted_message_tm3 = 0
					PRINT_NOW ( WANTED1 ) 5000 1
					flag_displayed_wanted_message_tm3 = 1
				ENDIF
			ELSE
				IF flag_displayed_horn_message_tm3 = 0
					PRINT_NOW ( HORN ) 5000 1
					flag_displayed_horn_message_tm3 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_AREA_IN_CAR_3D player 903.8 -420.2 14.0 908.3 -431.1 18.0 FALSE
		IF flag_displayed_horn_message_tm3 = 1
		OR flag_displayed_wanted_message_tm3 = 1
			CLEAR_THIS_PRINT ( WANTED1 )
			CLEAR_THIS_PRINT ( HORN )
			flag_displayed_horn_message_tm3 = 0
			flag_displayed_wanted_message_tm3 = 0
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_HEALTH_GREATER carry_car 600
		WAIT 500
		IF IS_CAR_DEAD carry_car
			PRINT_NOW (TM3_A1) 5000 1 //Joeys dead
			GOTO mission_toni3_failed
		ENDIF
		PRINT_NOW ( TRASH ) 5000 2 //Repair the car!
		REMOVE_BLIP blip1_t3
		REMOVE_BLIP blip3_t3
		ADD_BLIP_FOR_CAR carry_car blip1_t3
		CHANGE_BLIP_DISPLAY blip1_t3 BLIP_ONLY
		flag_car_blip_displayed = TRUE

		WHILE NOT IS_CAR_HEALTH_GREATER carry_car 600
			WAIT 0 

			IF IS_CAR_DEAD carry_car
				PRINT_NOW (TM3_A1) 5000 1 //Joeys dead
				GOTO mission_toni3_failed
			ENDIF

			IF IS_PLAYER_IN_CAR player carry_car
				IF flag_car_blip_displayed = TRUE
					//ADD_BLIP_FOR_COORD 925.0 -359.5 -100.0 blip5_t3
					ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY blip5_t3
					REMOVE_BLIP blip1_t3
				flag_car_blip_displayed = FALSE
				ENDIF
			ENDIF

			IF NOT IS_PLAYER_IN_CAR player carry_car
				IF flag_car_blip_displayed = FALSE
					ADD_BLIP_FOR_CAR carry_car blip1_t3
					REMOVE_BLIP blip5_t3
					PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the carry_car!"
					flag_car_blip_displayed = TRUE
				ENDIF
			ENDIF

		ENDWHILE

			REMOVE_BLIP blip5_t3
			GOTO pick_up_Luigi			
	ENDIF
	

ENDWHILE

CLEAR_THIS_PRINT ( WANTED1 )
CLEAR_THIS_PRINT ( HORN )

IF NOT IS_CAR_DEAD carry_car
	LOCK_CAR_DOORS carry_car CARLOCK_LOCKED_PLAYER_INSIDE
ENDIF

WAIT 500

SET_PLAYER_CONTROL Player Off
SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER Player ON
SET_EVERYONE_IGNORE_PLAYER Player ON
REMOVE_BLIP blip3_t3

IF NOT IS_CAR_DEAD carry_car
	LOCK_CAR_DOORS carry_car CARLOCK_UNLOCKED
ENDIF

CLEAR_AREA 897.0 -425.5 14.7 6.0 TRUE

//SET_FIXED_CAMERA_POSITION 903.2 -427.7 16.6 0.0 0.0 0.0
//POINT_CAMERA_AT_CHAR luigi FIXED JUMP_CUT
SET_FIXED_CAMERA_POSITION 900.505 -419.672 14.976 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 900.937 -420.566 15.093 JUMP_CUT

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL3 897.0 -425.3 14.8 luigi
CLEAR_CHAR_THREAT_SEARCH luigi


SET_PED_DENSITY_MULTIPLIER 0.0

TIMERB = 0
LOAD_MISSION_AUDIO T3_B

 SET_CHAR_OBJ_GOTO_COORD_ON_FOOT luigi 901.0 -426.4

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED luigi
		WAIT 0

		IF IS_CHAR_DEAD luigi
			GOTO mission_toni3_failed
		ENDIF

		IF IS_CAR_DEAD carry_car
			GOTO mission_toni3_failed
		ENDIF

		IF TIMERB > 12000
			IF NOT IS_CHAR_DEAD	luigi
				SET_CHAR_COORDINATES luigi 901.0 -426.4 -100.0
			ENDIF
		ENDIF

	ENDWHILE


SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER luigi carry_car

	WHILE NOT IS_CHAR_IN_CAR luigi carry_car 
		WAIT 0

	 	IF IS_CHAR_DEAD luigi
			GOTO mission_toni3_failed
		ENDIF

		IF IS_CAR_DEAD carry_car
			GOTO mission_toni3_failed
		ENDIF

	ENDWHILE

SET_CHAR_CANT_BE_DRAGGED_OUT luigi TRUE

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO

SET_PLAYER_CONTROL Player On
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN OFF
SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF
SET_PED_DENSITY_MULTIPLIER 1.0

SWITCH_PED_ROADS_ON 824.9 -633.8 13.0 845.3 -693.8 18.0 
SWITCH_ROADS_ON 824.9 -633.8 13.0 845.3 -693.8 18.0

flag_displayed_horn_message_tm3 = 0
flag_displayed_wanted_message_tm3 = 0


//PICK UP TONI

pick_up_toni:

flag_car_blip_displayed = TRUE
blob_flag = 1

IF NOT IS_CAR_DEAD carry_car
	IF NOT IS_PLAYER_IN_CAR player carry_car
		REMOVE_BLIP blip1_t3
		ADD_BLIP_FOR_CAR carry_car blip1_t3
		blob_flag = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the carry_car!"
	ENDIF
ENDIF

WHILE NOT IS_PLAYER_STOPPED_IN_AREA_3D player 1197.8 -321.0 24.3 1202.0 -327.5 28.0 blob_flag
OR NOT IS_PLAYER_IN_CAR player carry_car
OR NOT IS_PLAYER_PRESSING_HORN player
OR IS_WANTED_LEVEL_GREATER Player 0

	WAIT 0

	IF IS_CAR_DEAD carry_car
		PRINT_NOW (TM3_A2) 5000 1 //Joey and Luigi are dead
		GOTO mission_toni3_failed
	ENDIF
   
	IF IS_PLAYER_IN_CAR player carry_car
		IF flag_car_blip_displayed = TRUE
			ADD_BLIP_FOR_COORD 1200.5 -322.5 -100.0 blip4_t3
			blob_flag = 1
			REMOVE_BLIP blip1_t3
		flag_car_blip_displayed = FALSE
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player carry_car
		IF flag_car_blip_displayed = FALSE
			REMOVE_BLIP blip1_t3
			ADD_BLIP_FOR_CAR carry_car blip1_t3
			blob_flag = 0
			REMOVE_BLIP blip4_t3
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the carry_car!"
			flag_car_blip_displayed = TRUE
		ENDIF
	ENDIF

	IF IS_PLAYER_STOPPED_IN_AREA_IN_CAR_3D player 1197.8 -321.0 24.3 1202.0 -327.5 28.0 FALSE
		IF IS_PLAYER_IN_CAR player carry_car

			IF IS_WANTED_LEVEL_GREATER player 0
				IF flag_displayed_wanted_message_tm3 = 0
					PRINT_NOW ( WANTED1 ) 5000 1
					flag_displayed_wanted_message_tm3 = 1
				ENDIF
			ELSE
				IF flag_displayed_horn_message_tm3 = 0
					PRINT_NOW ( HORN ) 5000 1
					flag_displayed_horn_message_tm3 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_PLAYER_IN_AREA_IN_CAR_3D player 1197.8 -321.0 24.3 1202.0 -327.5 28.0 FALSE
		IF flag_displayed_horn_message_tm3 = 1
		OR flag_displayed_wanted_message_tm3 = 1
			CLEAR_THIS_PRINT ( WANTED1 )
			CLEAR_THIS_PRINT ( HORN )
			flag_displayed_horn_message_tm3 = 0
			flag_displayed_wanted_message_tm3 = 0
		ENDIF
	ENDIF

	IF NOT IS_CAR_HEALTH_GREATER carry_car 600
		WAIT 500
		IF IS_CAR_DEAD carry_car
			PRINT_NOW (TM3_A2) 5000 1 //Joey and Luigi are dead
			GOTO mission_toni3_failed
		ENDIF
		PRINT_NOW ( TRASH ) 5000 2 //Repair the car!
		REMOVE_BLIP blip1_t3
		REMOVE_BLIP blip4_t3
		ADD_BLIP_FOR_CAR carry_car blip1_t3
		CHANGE_BLIP_DISPLAY blip1_t3 BLIP_ONLY		
		flag_car_blip_displayed = TRUE

		WHILE NOT IS_CAR_HEALTH_GREATER carry_car 600
			WAIT 0 

			IF IS_CAR_DEAD carry_car
				PRINT_NOW (TM3_A2) 5000 1 //Joey and Luigi are dead
				GOTO mission_toni3_failed
			ENDIF

			IF IS_PLAYER_IN_CAR player carry_car
				IF flag_car_blip_displayed = TRUE
					ADD_SPRITE_BLIP_FOR_COORD 925.0 -359.5 -100.0 RADAR_SPRITE_SPRAY blip5_t3
					REMOVE_BLIP blip1_t3
				flag_car_blip_displayed = FALSE
				ENDIF
			ENDIF

			IF NOT IS_PLAYER_IN_CAR player carry_car
				IF flag_car_blip_displayed = FALSE
					ADD_BLIP_FOR_CAR carry_car blip1_t3
					REMOVE_BLIP blip5_t3
					PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the carry_car!"
					flag_car_blip_displayed = TRUE
				ENDIF
			ENDIF

		ENDWHILE

		REMOVE_BLIP blip5_t3
		GOTO pick_up_toni
	ENDIF
	

ENDWHILE

CLEAR_THIS_PRINT ( WANTED1 )
CLEAR_THIS_PRINT ( HORN )

IF NOT IS_CAR_DEAD carry_car
	LOCK_CAR_DOORS carry_car CARLOCK_LOCKED_PLAYER_INSIDE
ENDIF

WAIT 500

SET_PLAYER_CONTROL Player Off
SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER Player ON
SET_EVERYONE_IGNORE_PLAYER Player ON
REMOVE_BLIP blip4_t3

IF NOT IS_CAR_DEAD carry_car
	LOCK_CAR_DOORS carry_car CARLOCK_UNLOCKED
ENDIF

CLEAR_AREA 1213.6 -321.1 26.5 10.0 TRUE

CREATE_CHAR PEDTYPE_SPECIAL PED_SPECIAL1 1217.0 -321.1 -100.0 toni
SET_CHAR_HEADING toni 90.0
CLEAR_CHAR_THREAT_SEARCH toni

//SET_FIXED_CAMERA_POSITION 1211.6 -323.7 28.0 0.0 0.0 0.0
//POINT_CAMERA_AT_CHAR toni FIXED JUMP_CUT
SET_FIXED_CAMERA_POSITION 1222.214 -328.629 34.454 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 1221.629 -328.046 33.891 JUMP_CUT

SET_PED_DENSITY_MULTIPLIER 0.0
/*
TIMERB = 0

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT toni 1219.2 -320.9

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED toni
		WAIT 0

		IF IS_CHAR_DEAD toni
			GOTO mission_toni3_failed
		ENDIF

		IF IS_CAR_DEAD carry_car
			GOTO mission_toni3_failed
		ENDIF

		IF TIMERB > 12000
			IF NOT IS_CHAR_DEAD	toni
				SET_CHAR_COORDINATES toni 1219.2 -320.9 26.4
			ENDIF
		ENDIF

	ENDWHILE
*/
TIMERB = 0

LOAD_MISSION_AUDIO T3_C

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT toni 1205.5 -321.0

	WHILE NOT IS_CHAR_OBJECTIVE_PASSED toni
		WAIT 0

		IF IS_CHAR_DEAD toni
			GOTO mission_toni3_failed
		ENDIF

		IF IS_CAR_DEAD carry_car
			GOTO mission_toni3_failed
		ENDIF

		IF TIMERB > 12000
			IF NOT IS_CHAR_DEAD	toni
				SET_CHAR_COORDINATES toni 1205.5 -321.0 -100.0
			ENDIF
		ENDIF

	ENDWHILE


SET_FIXED_CAMERA_POSITION 1206.2 -326.2 27.0 0.0 0.0 0.0
POINT_CAMERA_AT_CHAR toni FIXED JUMP_CUT
SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER toni carry_car

	WHILE NOT IS_CHAR_IN_CAR toni carry_car 
		WAIT 0

	 	IF IS_CHAR_DEAD toni
			GOTO mission_toni3_failed
		ENDIF

		IF IS_CAR_DEAD carry_car
			GOTO mission_toni3_failed
		ENDIF

	ENDWHILE

WHILE NOT HAS_MISSION_AUDIO_LOADED
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO

SET_CHAR_CANT_BE_DRAGGED_OUT toni TRUE
SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF
SET_PED_DENSITY_MULTIPLIER 1.0


//YET ANOTHER AMBUSH BY THE TRIADS

CREATE_CAR CAR_BELLYUP 1193.0 -228.0 -100.0 triad_van1
SET_CAR_HEADING triad_van1 180.0
SET_CAR_DRIVING_STYLE triad_van1 3
SET_CAR_CRUISE_SPEED triad_van1 30.0
SET_CAR_STRONG triad_van1 TRUE

			CREATE_CHAR_INSIDE_CAR triad_van1 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A triads1
			GIVE_WEAPON_TO_CHAR triads1 WEAPONTYPE_PISTOL 100
			SET_CAR_MISSION  triad_van1 2
			SET_CHAR_THREAT_SEARCH triads1 THREAT_PLAYER1

			CREATE_CHAR_AS_PASSENGER triad_van1 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 0 triads2
			GIVE_WEAPON_TO_CHAR triads2 WEAPONTYPE_PISTOL 100
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS triads2 Player
			//SET_CHAR_OBJ_DESTROY_CAR triads2 carry_car
			SET_CHAR_THREAT_SEARCH triads2 THREAT_PLAYER1

CREATE_CAR CAR_BELLYUP 1275.8 -346.7 -100.0 triad_van2
SET_CAR_HEADING triad_van2 1.0
SET_CAR_DRIVING_STYLE triad_van2 3
SET_CAR_CRUISE_SPEED triad_van2 30.0
SET_CAR_STRONG triad_van2 TRUE

			CREATE_CHAR_INSIDE_CAR triad_van2 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A triads3
			GIVE_WEAPON_TO_CHAR triads3 WEAPONTYPE_PISTOL 100
			SET_CAR_MISSION  triad_van2 2
			SET_CHAR_THREAT_SEARCH triads3 THREAT_PLAYER1

			CREATE_CHAR_AS_PASSENGER triad_van2 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 0 triads4
			GIVE_WEAPON_TO_CHAR triads4 WEAPONTYPE_PISTOL 100
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS triads4 Player
			//SET_CHAR_OBJ_DESTROY_CAR triads4 carry_car
			SET_CHAR_THREAT_SEARCH triads4 THREAT_PLAYER1

CREATE_CAR CAR_BELLYUP 1342.5 -281.5 -100.0 triad_van3
SET_CAR_HEADING triad_van3 90.0
SET_CAR_DRIVING_STYLE triad_van3 3
SET_CAR_CRUISE_SPEED triad_van3 30.0	
SET_CAR_STRONG triad_van3 TRUE

			CREATE_CHAR_INSIDE_CAR triad_van3 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A triads5
			GIVE_WEAPON_TO_CHAR triads5 WEAPONTYPE_PISTOL 100
			SET_CAR_MISSION  triad_van3 2
			SET_CHAR_THREAT_SEARCH triads5 THREAT_PLAYER1

			CREATE_CHAR_AS_PASSENGER triad_van3 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 0 triads6
			GIVE_WEAPON_TO_CHAR triads6 WEAPONTYPE_PISTOL 100
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS triads6 Player
			//SET_CHAR_OBJ_DESTROY_CAR triads6 carry_car
			SET_CHAR_THREAT_SEARCH triads6 THREAT_PLAYER1

CREATE_CAR CAR_BELLYUP 1121.6 -345.2 -100.0 triad_van4
SET_CAR_HEADING triad_van4 270.0
SET_CAR_DRIVING_STYLE triad_van4 3
SET_CAR_CRUISE_SPEED triad_van4 30.0	
SET_CAR_STRONG triad_van4 TRUE

			CREATE_CHAR_INSIDE_CAR triad_van4 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A triads7
			GIVE_WEAPON_TO_CHAR triads7 WEAPONTYPE_PISTOL 100
			SET_CAR_MISSION triad_van4 2
			SET_CHAR_THREAT_SEARCH triads7 THREAT_PLAYER1

			CREATE_CHAR_AS_PASSENGER triad_van4 PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 0 triads8
			GIVE_WEAPON_TO_CHAR triads8 WEAPONTYPE_PISTOL 100
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS triads8 Player
			//SET_CHAR_OBJ_DESTROY_CAR triads8 carry_car
			SET_CHAR_THREAT_SEARCH triads8 THREAT_PLAYER1

//ROAD BLOCK

CREATE_CAR CAR_BELLYUP 1383.3 -285.0 -100.0 triad_van5
SET_CAR_HEADING triad_van5 10.0

CREATE_CAR CAR_BELLYUP 1383.3 -279.0 -100.0 triad_van6
SET_CAR_HEADING triad_van6 160.0

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_A 1382.1 -281.7 -100.0 triads9
GIVE_WEAPON_TO_CHAR triads9 WEAPONTYPE_PISTOL 100
SET_CHAR_STAY_IN_SAME_PLACE triads9 TRUE
SET_CHAR_OBJ_DESTROY_CAR triads9 carry_car
SET_CHAR_THREAT_SEARCH triads9 THREAT_PLAYER1

CREATE_CHAR PEDTYPE_GANG_TRIAD PED_GANG_TRIAD_B 1384.3 -291.5 -100.0 triads10
GIVE_WEAPON_TO_CHAR triads10 WEAPONTYPE_PISTOL 100
SET_CHAR_STAY_IN_SAME_PLACE triads10 TRUE
SET_CHAR_OBJ_DESTROY_CAR triads10 carry_car
SET_CHAR_THREAT_SEARCH triads10 THREAT_PLAYER1

POINT_CAMERA_AT_CAR triad_van1 BEHINDCAR INTERPOLATION

WAIT 3000

SET_PLAYER_CONTROL Player On
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT


//GO TO FRANKIES

get_to_frankies:

flag_car_blip_displayed = TRUE

IF NOT IS_CAR_DEAD carry_car
	SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage carry_car
ENDIF

IF NOT IS_CAR_DEAD carry_car
	IF NOT IS_PLAYER_IN_CAR player carry_car
		REMOVE_BLIP blip1_t3
		ADD_BLIP_FOR_CAR carry_car blip1_t3
		blob_flag = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the carry_car!"
	ENDIF
ENDIF

WHILE NOT IS_CAR_IN_MISSION_GARAGE frankie_garage
//OR NOT IS_PLAYER_IN_CAR player carry_car
	WAIT 0

		IF IS_CAR_DEAD carry_car
			PRINT_NOW (TM3_A3) 5000 1 //Joey, luigi and Toni are dead
			GOTO mission_toni3_failed
		ENDIF

		IF IS_PLAYER_IN_CAR player carry_car
			IF flag_car_blip_displayed = TRUE
				ADD_BLIP_FOR_COORD 1428.6 -183.1 -100.0 blip2_t3
				CHANGE_BLIP_DISPLAY blip2_t3 BLIP_ONLY
				REMOVE_BLIP blip1_t3
			flag_car_blip_displayed = FALSE
			ENDIF
		ENDIF

		IF NOT IS_PLAYER_IN_CAR player carry_car
			IF flag_car_blip_displayed = FALSE
			ADD_BLIP_FOR_CAR carry_car blip1_t3
			REMOVE_BLIP blip2_t3
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back in the carry_car!"
			flag_car_blip_displayed = TRUE
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD triad_van1
			IF IS_CAR_IN_AREA_2D triad_van1 1393.6 -268.2 1427.1 -154.1 FALSE
				IF NOT IS_CHAR_DEAD triads1
				AND NOT IS_CHAR_DEAD triads2
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads1 Player
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads2 Player
				ENDIF	
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD triad_van2
			IF IS_CAR_IN_AREA_2D triad_van2 1393.6 -268.2 1427.1 -154.1 FALSE
				IF NOT IS_CHAR_DEAD triads3
				AND NOT IS_CHAR_DEAD triads4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads3 Player
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads4 Player
				ENDIF	
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD triad_van3
			IF IS_CAR_IN_AREA_2D triad_van3 1393.6 -268.2 1427.1 -154.1 FALSE
				IF NOT IS_CHAR_DEAD triads5
				AND NOT IS_CHAR_DEAD triads6
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads5 Player
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads6 Player
				ENDIF	
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD triad_van4
			IF IS_CAR_IN_AREA_2D triad_van4 1393.6 -268.2 1427.1 -154.1 FALSE
				IF NOT IS_CHAR_DEAD triads7
				AND NOT IS_CHAR_DEAD triads8
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads7 Player
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT triads8 Player
				ENDIF	
			ENDIF
		ENDIF

ENDWHILE


REMOVE_BLIP blip1_t3
REMOVE_BLIP blip2_t3
SET_FIXED_CAMERA_POSITION 1421.8 -182.5 52.5 0.0 0.0 0.0
POINT_CAMERA_AT_CAR carry_car FIXED INTERPOLATION

WAIT 1000

SET_POLICE_IGNORE_PLAYER Player OFF
SET_EVERYONE_IGNORE_PLAYER Player OFF

IF IS_PLAYER_IN_ANY_CAR player
	WARP_PLAYER_FROM_CAR_TO_COORD player 1454.6 -189.5 55.0
ELSE
	SET_PLAYER_COORDINATES Player 1454.6 -189.5 55.0
ENDIF

	IF NOT IS_CHAR_DEAD triads1
		DELETE_CHAR triads1
	ENDIF
	IF NOT IS_CHAR_DEAD triads2
		DELETE_CHAR triads2
	ENDIF
	IF NOT IS_CHAR_DEAD triads3
		DELETE_CHAR triads3
	ENDIF
	IF NOT IS_CHAR_DEAD triads4
		DELETE_CHAR triads4
	ENDIF
	IF NOT IS_CHAR_DEAD triads5
		DELETE_CHAR triads5
	ENDIF
	IF NOT IS_CHAR_DEAD triads6
		DELETE_CHAR triads6
	ENDIF
	IF NOT IS_CHAR_DEAD triads7
		DELETE_CHAR triads7
	ENDIF
	IF NOT IS_CHAR_DEAD triads8
		DELETE_CHAR triads8
	ENDIF
	IF NOT IS_CHAR_DEAD triads9
		DELETE_CHAR triads9
	ENDIF
	IF NOT IS_CHAR_DEAD triads10
		DELETE_CHAR triads10
	ENDIF
	IF NOT IS_CAR_DEAD triad_van1
		DELETE_CAR triad_van1
	ENDIF
	IF NOT IS_CAR_DEAD triad_van2
		DELETE_CAR triad_van2
	ENDIF
	IF NOT IS_CAR_DEAD triad_van3
		DELETE_CAR triad_van3
	ENDIF
	IF NOT IS_CAR_DEAD triad_van4
		DELETE_CAR triad_van4
	ENDIF
	IF NOT IS_CAR_DEAD triad_van5
		DELETE_CAR triad_van5
	ENDIF
	IF NOT IS_CAR_DEAD triad_van6
		DELETE_CAR triad_van6
	ENDIF

//skip_to_toni3_cut: //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//LOAD_SCENE 1457.776 -185.348 54.925	//TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//SET_PLAYER_COORDINATES player 1454.6 -189.5 55.0 //TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


	GET_GAME_TIMER breakout_timer_start
	breakout_diff = 0

	WHILE NOT CAN_PLAYER_START_MISSION Player
	AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
		WAIT 0

		IF IS_CAR_DEAD carry_car
			PRINT_NOW (TM3_A3) 5000 1 //Joey, luigi and Toni are dead
			GOTO mission_toni3_failed
		ENDIF

		GET_GAME_TIMER breakout_timer							
		breakout_diff = breakout_timer - breakout_timer_start
	ENDWHILE

	MAKE_PLAYER_SAFE_FOR_CUTSCENE Player


// ****************************************START OF CUTSCENE2********************************
 
SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

CLEAR_AREA 1427.0 -187.8 50.0 12.0 TRUE
CLEAR_AREA 1444.99 -186.9 56.0 30.0 TRUE

SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 4 frankie
REQUEST_MODEL PED_GANG_MAFIA_B

LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
LOAD_SPECIAL_MODEL cut_obj2 FRANKH
LOAD_SPECIAL_MODEL cut_obj3 JOEYH
LOAD_SPECIAL_MODEL cut_obj4 LUIGIH
LOAD_SPECIAL_MODEL cut_obj5 TONYH
REQUEST_MODEL salvsdetail
REQUEST_MODEL swank_inside
REQUEST_MODEL franksclb02

WHILE GET_FADING_STATUS
	WAIT 0

ENDWHILE

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_MODEL_LOADED PED_GANG_MAFIA_B
OR NOT HAS_MODEL_LOADED	salvsdetail
OR NOT HAS_MODEL_LOADED swank_inside
OR NOT HAS_MODEL_LOADED	franksclb02
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED cut_obj1
OR NOT HAS_MODEL_LOADED cut_obj2
OR NOT HAS_MODEL_LOADED cut_obj3
OR NOT HAS_MODEL_LOADED cut_obj4
OR NOT HAS_MODEL_LOADED cut_obj5
	WAIT 0
ENDWHILE

LOAD_CUTSCENE S0_MAS
SET_CUTSCENE_OFFSET 1457.776 -185.348 54.925

CREATE_CUTSCENE_OBJECT PED_PLAYER cs_player
SET_CUTSCENE_ANIM cs_player player

CREATE_CUTSCENE_OBJECT PED_SPECIAL1 cs_tony
SET_CUTSCENE_ANIM cs_tony tony

CREATE_CUTSCENE_OBJECT PED_SPECIAL2 cs_joey
SET_CUTSCENE_ANIM cs_joey joey2

CREATE_CUTSCENE_OBJECT PED_SPECIAL3 cs_luigi
SET_CUTSCENE_ANIM cs_luigi luigi

CREATE_CUTSCENE_OBJECT PED_SPECIAL4 cs_frankie
SET_CUTSCENE_ANIM cs_frankie frankie

CREATE_CUTSCENE_OBJECT PED_GANG_MAFIA_B cs_mafia
SET_CUTSCENE_ANIM cs_mafia gang02

CREATE_CUTSCENE_HEAD cs_player cut_obj1 cs_playerhead
SET_CUTSCENE_HEAD_ANIM cs_playerhead player

CREATE_CUTSCENE_HEAD cs_frankie cut_obj2 cs_frankiehead
SET_CUTSCENE_HEAD_ANIM cs_frankiehead frank

CREATE_CUTSCENE_HEAD cs_joey cut_obj3 cs_joeyhead
SET_CUTSCENE_HEAD_ANIM cs_joeyhead joey

CREATE_CUTSCENE_HEAD cs_luigi cut_obj4 cs_luigihead
SET_CUTSCENE_HEAD_ANIM cs_luigihead luigi

CREATE_CUTSCENE_HEAD cs_tony cut_obj5 cs_tonyhead
SET_CUTSCENE_HEAD_ANIM cs_tonyhead tony

//SET_PLAYER_COORDINATES player 1455.2 -186.8 55.0

SET_PLAYER_HEADING player 341.0

DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 416 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_H 10000 1

WHILE cs_time < 3252
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_I 10000 1

WHILE cs_time < 4866
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_J 10000 1

WHILE cs_time < 5839
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_K 10000 1

WHILE cs_time < 10201
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_L 10000 1

WHILE cs_time < 13769
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_M 10000 1

WHILE cs_time < 17654
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_N 10000 1

WHILE cs_time < 18718
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_N2 10000 1

WHILE cs_time < 19529
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_O 10000 1

WHILE cs_time < 21673
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_P 10000 1

WHILE cs_time < 25525
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_Q 10000 1

WHILE cs_time < 26615
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_R 10000 1

WHILE cs_time < 29462
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_S 10000 1

WHILE cs_time < 32814
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_T 10000 1

WHILE cs_time < 35855
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_U 10000 1

WHILE cs_time < 37787
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_V 10000 1

WHILE cs_time < 44707
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW TM3_W 10000 1

WHILE cs_time < 47837
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 48666
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT
WHILE GET_FADING_STATUS
WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
WAIT 0
ENDWHILE

CLEAR_PRINTS

DO_FADE 0 FADE_OUT

CLEAR_CUTSCENE

DO_FADE 0 FADE_OUT

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj1
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj2
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj3
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj4
MARK_MODEL_AS_NO_LONGER_NEEDED cut_obj5
MARK_MODEL_AS_NO_LONGER_NEEDED salvsdetail
MARK_MODEL_AS_NO_LONGER_NEEDED swank_inside
MARK_MODEL_AS_NO_LONGER_NEEDED franksclb02

WAIT 500

DO_FADE 1500 FADE_IN


}
		
GOTO mission_toni3_passed  
			


 // Mission toni3 failed

mission_toni3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission toni3 passed

mission_toni3_passed:

flag_toni_mission3_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 15000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player
ADD_SCORE player 15000
REGISTER_MISSION_PASSED	TM3
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT frankie_mission1_loop
REMOVE_BLIP	luigi_contact_blip
REMOVE_BLIP	joey_contact_blip
REMOVE_BLIP	toni_contact_blip
REMOVE_BLIP frankie_contact_blip
ADD_SPRITE_BLIP_FOR_CONTACT_POINT 1455.7 -187.3 -100.0 RADAR_SPRITE_SAL frankie_contact_blip
//WAIT 3000						  
//WARP_PLAYER_FROM_CAR_TO_COORD player 1455.7 -187.3 -100.0
DELETE_CAR carry_car				 
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER
RETURN
		


// mission cleanup

mission_cleanup_toni3:

flag_player_on_mission = 0
flag_player_on_toni_mission = 0
REMOVE_BLIP blip1_t3
REMOVE_BLIP blip2_t3
REMOVE_BLIP blip3_t3
REMOVE_BLIP blip4_t3
REMOVE_BLIP blip5_t3
REMOVE_CHAR_ELEGANTLY joey
REMOVE_CHAR_ELEGANTLY luigi
REMOVE_CHAR_ELEGANTLY toni
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_STRETCH
MARK_MODEL_AS_NO_LONGER_NEEDED CAR_BELLYUP
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_A
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_TRIAD_B
MARK_MODEL_AS_NO_LONGER_NEEDED PED_GANG_MAFIA_B
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
SET_TARGET_CAR_FOR_MISSION_GARAGE frankie_garage -1
CLEAR_THIS_PRINT ( IN_VEH )
MISSION_HAS_FINISHED
RETURN

