var App = React.createClass({
	
	render: function(){
		return (
			<div>
				<h1>Tech News</h1>
				<Articles />	
			</div>
		);
	}
	
});

ReactDOM.render(<App />, document.getElementById("App"));