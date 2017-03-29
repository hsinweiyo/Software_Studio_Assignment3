104062111 游欣為 Assignment3

How does it work
	[Create Pokemon]
		- Click the slot, which must be empty and you want to add pokemon in
		- Select species from the combo box
		- Type in nick name, 6 values in corresponding fields
		- Click the "save" button
		- There will be 'morris_new_pokemon.json' to store [PokemonIndividualData]'s json file 
		- Keep create pokemon in the same way

	[Edit Pokemon]
		- Click the slot you want to edit
		- Click the "edit" button; otherwise, you can't change any value of the pokemon
		- Then change the value you want

	[Delete]
		- Select the slot you want to delete
		- Click the "delete" button
		- Update the json file

Details
	- Add ActionListener for the buttons
	- Add MouseListener for the slots, the border will change as long as you click it or change slot
	- There's a arraylist{statFields} to store all the TextFields
	- The type information is get from the pokedex
	! The input Area is control by {setEditable} and {setEnabled}
	- There's a new pokedex{newpokedex} for the pokemon you create
	! The icon is in the center of the panel

Problem encounter
	[Id != Combo Index]
		According to the mega subtype, the ID of the speices can't match the ComboBox, so I save the comboindex in the individualData in order to remember the combox selection we have to show.
	[Json File]
		1. I first save file in the same file, and it turns out it saves gson of 908 items. So I create another pokedex to save the new pokemon.
		2. Can not use the method of pokedex for the IndividualData, because the attribute in pokedex is SpeciesData. Therefore, I write a method for Individual ones.
