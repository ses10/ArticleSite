var Articles = React.createClass({
	
	componentDidMount: function(){
		fetch("http://localhost:8080/articles?page=0&size=10")
		.then(response => response.json())
		.then(json => console.log(json));
		
	},
	
	render: function(){
		return (
			<h1>Articles</h1>
		);
	}
	
});