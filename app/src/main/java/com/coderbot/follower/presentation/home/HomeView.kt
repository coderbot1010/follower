package com.coderbot.follower.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.coderbot.follower.R
import com.coderbot.follower.data.model.User
import com.coderbot.follower.presentation.common_views.Error
import com.coderbot.follower.presentation.common_views.GridView
import com.coderbot.follower.presentation.common_views.Loading
import com.coderbot.follower.presentation.common_views.TextView
import com.coderbot.follower.ui.theme.PrimaryColor
import com.google.accompanist.coil.rememberCoilPainter
import org.koin.androidx.compose.getViewModel

@Composable
fun Home(navController: NavController? = null, viewModel: HomeViewModel = getViewModel())
{
    val state = viewModel.state.observeAsState(initial = HomeViewState.ViewInitializationState)

    HomeView()

    when (val viewState = state.value)
    {
        is HomeViewState.ViewInitializationState -> viewModel.intent.value = HomeViewIntents.GetUsers
        is HomeViewState.DataState -> HomeView(viewState.users) {
            println(it)
            viewModel.intent.value = HomeViewIntents.ToggleUser(it)
        }
        is HomeViewState.ErrorState -> Error(error = viewState.error.message ?: stringResource(id = R.string.error))
        is HomeViewState.LoadingState -> Loading()
    }
}

@Composable
fun HomeView(users: MutableList<User> = mutableListOf(), itemAction: (Int) -> Unit = { })
{
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(7.dp),
        topBar = { TopBar() }
    ) {
        GridView(items = users) {
            CategoryItem(it, itemAction)
        }
    }
}

@Composable
private fun TopBar()
{
    TopAppBar(
        title = { TextView(text = stringResource(id = R.string.app_name), color = PrimaryColor) },
        elevation = 5.dp,
        backgroundColor = Color.White
    )
}

@Composable
private fun CategoryItem(user: User, itemAction: (Int) -> Unit)
{
    Card(
        backgroundColor = Color.White,
        elevation = 7.dp,
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(shape = CircleShape, border = BorderStroke(width = 2.dp, color = PrimaryColor), modifier = Modifier.padding(16.dp)) {
                Image(
                    painter = rememberCoilPainter(user.avatar),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(100.dp))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextView(text = "${user.firstName} ${user.lastName}", size = 14, color = PrimaryColor)
                Image(painterResource(id = if (user.followed) R.drawable.ic_followed else R.drawable.ic_unfollowed), contentDescription = "", modifier = Modifier
                    .size(24.dp)
                    .clickable { itemAction(user.id) })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeViewPreview()
{
    HomeView()
}