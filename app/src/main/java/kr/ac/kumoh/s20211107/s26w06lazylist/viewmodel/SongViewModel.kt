package kr.ac.kumoh.s20211107.s26w06lazylist.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.ac.kumoh.s20211107.s26w06lazylist.model.Song

class SongViewModel : ViewModel() {
    private val _songs = MutableStateFlow<List<Song>>(emptyList())
    val songs = _songs.asStateFlow()

    init {
        var id = 1

        repeat(30) { index ->
            add(Song(id++, "Neon Horizon $index", "Pixel Wave"))
            add(Song(id++, "Midnight Coffee $index", "The Afterhours"))
            add(Song(id++, "Gravity Reset $index", "Lunarcat"))
            add(Song(
                id = id++,
                title = "우리가 함께 나누었던 그 수많았던 밤들과 채워지지 않을 새벽녘의 빈자리 $index",
                singer = "새벽 공방전"
            ))

            add(Song(
                id = id++,
                title = "네가 머물다 떠나간 그 계절의 끝자락에서 아직도 난 너의 이름을 나지막이 불러보고 있어 $index",
                singer = "오후 두 시의 기억"
            ))

            add(Song(
                id = id++,
                title = "우주를 건너 너에게 닿을 수만 있다면 내 모든 조각들을 모아 너라는 행성으로 갈 텐데 $index",
                singer = "Stellar Void"
            ))
        }
    }

    fun add(song: Song) {
        // 새로운 리스트를 만들고 song 추가
        // Shallow copy
        _songs.update { it + song }
    }
}