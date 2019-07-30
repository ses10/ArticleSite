var App = React.createClass({
	
	render: function(){
		return (
			<div>
				<Articles />	
			</div>
		);
	}
	
});

ReactDOM.render(<App />, document.getElementById("App"));