var Articles = React.createClass({
	getInitialState: function(){
		return{
			currentPage: 0,
			pageSize: 10,
			articles: [],
			finalPage: false
		};
	},
	
	componentDidMount: function(){
		this.fetchArticles();
	},
	
	fetchArticles: function(){
		fetch("http://localhost:8080/articles?page=" + this.state.currentPage + "&size=" + this.state.pageSize)
		.then(response => response.json())
		.then(json => this.loadArticles(json) );
	},
	
	loadArticles: function(articles){
		if(articles.length != 0)
			this.setState( {articles: articles} );
		else
			//go back a page since the current page is empty
			this.setState( {currentPage: this.state.currentPage - 1, finalPage: true} );
	},
	
	handlePrevClick: function(){
		if(this.state.currentPage > 0)
			this.setState({currentPage: this.state.currentPage - 1, finalPage: false}, () => this.fetchArticles());
	},
	
	handleNextClick: function(){
		if(!this.state.finalPage)
			this.setState({currentPage: this.state.currentPage + 1}, () => this.fetchArticles());
	},
	
	render: function(){
		return (
			<div>
				<table>
					<tbody>
					{this.state.articles.map((article, index) => (
							<tr key={article.id} >
								<td>{article.by}</td>
								<td> <a href={article.url} target="_blank" >{article.title}</a> </td>
							</tr>
					))}
					</tbody>
				</table>
				<button onClick={this.handlePrevClick}>Prev</button>
				<button onClick={this.handleNextClick}>Next</button>
			</div>
		);
	}
	
});