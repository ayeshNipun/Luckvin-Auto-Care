import React from 'react';
import { Text, View, YellowBox  } from 'react-native';
import { fb } from './firebaseConfig/config';
import NetInfo from "@react-native-community/netinfo";

import WelcomeScreen from './Views/Screens/WelcomeScreen/WelcomeScreen';
import Drawer from './Views/Screens/Drawer';
import Location from './Views/Screens/MainWindows/Location/Location';
class App extends React.Component {
	constructor(props) {
		super(props);
		YellowBox.ignoreWarnings(['Setting a timer']);
		this.state = {
			//make this signup state false after editing profile.js
			signupState: false,
			email: '',
			password: '',
			user: null
		};



		// this.ref = fb.firestore().collection('Users');

		// console.log(this.ref.doc.data());
	}

	componentDidMount() {
		NetInfo.isConnected.fetch().then(isConnected => {
			console.log("Is connected", isConnected);
			if (isConnected) {
				fb.auth().onAuthStateChanged(function (user) {
					if (user) {
						// console.log(user);
						this.setState({
							user,
							signupState: true
						});
						// console.log(this.ref.doc.id);
					} else {
						this.setState({
							signupState: false
						});
					}
				}.bind(this));
			} else {
				alert("Check your connection.")
			}
		});
		
	}

	render() {
		if (!this.state.signupState) {
			return (
				<View style={{ flex: 1 }}>
					{/* <Test /> */}
					{/* <Profile/> */}
					{/* <Vehicles/> */}
					<WelcomeScreen />
				</View>
			);
		} else {
			return (
				<View style={{ flex: 1 }}>
					{/* <KeepAwake></KeepAwake> */}
					{/* <Text style={{color: "red"}}>dhfhgcgcghchgsdf</Text> */}
					{/* <Location /> */}
					<Drawer user={this.state.user}/>
				</View>
			);
		}
	}
}


export default App;