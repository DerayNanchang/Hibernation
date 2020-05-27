package com.lsn.hibernation.modules.music.presenter

import com.alibaba.fastjson.JSON
import com.lsn.hibernation.base.BasePresenter
import com.lsn.hibernation.base.Constant
import com.lsn.hibernation.base.IBaseView
import com.lsn.hibernation.base.ModelResponseAdapter2
import com.lsn.hibernation.db.bean.Album
import com.lsn.hibernation.db.bean.Music
import com.lsn.hibernation.db.bean.Playlist
import com.lsn.hibernation.db.bean.Singer
import com.lsn.hibernation.db.manager.PlaylistManager
import com.lsn.hibernation.manager.AlbumManager
import com.lsn.hibernation.manager.MusicManager
import com.lsn.hibernation.manager.SingerManager
import com.lsn.hibernation.modules.music.bean.RawPlaylistInfo
import com.lsn.hibernation.modules.music.contact.PlaylistContact
import com.lsn.hibernation.modules.music.model.PlaylistModelImpl
import io.reactivex.disposables.Disposable

/**
 * Author: lsn
 * Blog: https://www.jianshu.com/u/a3534a2292e8
 * Date: 2020/4/23 11:37
 * Description
 */
class PlaylistPresenterImpl(view: IBaseView) : BasePresenter<IBaseView>(view),
    PlaylistContact.PlaylistPresenter {

    private val mode = PlaylistModelImpl()

    override fun getPlaylistDetail(id: String) {
        mode.getPlaylistDetail(
            id,
            object :
                ModelResponseAdapter2<Playlist, RawPlaylistInfo, String>() {
                override fun onEmptyStatusResponse() {
                    super.onEmptyStatusResponse()
                    view?.onEmptyStatusResponse()
                }

                override fun onRequesting(disposable: Disposable?, cache: Playlist) {
                    super.onRequesting(disposable, cache)
                    view?.onSuccess(Constant.Music.Api.GET_PLAYLIST_DETAIL, true, cache)
                }

                override fun onSuccess(key: String?, result: RawPlaylistInfo) {
                    super.onSuccess(key, result)
                    if (result.code == Constant.Music.NET_EASE_SUCCESS_CODE) {
                        if (result.playlist.tracks.size > 0) {
                            result.playlist.tracks.forEach { track ->
                                val music = Music()
                                music.id = MusicManager.get.setMusicId(track.id)
                                music.name = track.name
                                music.netId = track.id
                                music.qqId = "0"
                                track.ar?.forEach {
                                    it?.let { ar ->
                                        val singer = Singer()
                                        singer.apply {
                                            //this.id = SingerManager.get.setSingerId(ar.id)
                                            this.id = SingerManager.get.setSingerId(music.id,ar.id)
                                            this.netId = ar.id
                                            this.qqId = "0"
                                            this.name = ar.name
                                            this.musicId = music.id
                                        }
                                        println("singer : " + JSON.toJSONString(singer))
                                        SingerManager.get.insert(singer)
                                    }
                                }

                                music.duration = track.dt.toLong()
                                music.isNet = true
                                music.type = Constant.Conn.EASE
                                music.albumId = AlbumManager.get.setAlbumId(track.al.id)
                                val album = Album()
                                album.id = AlbumManager.get.setAlbumId(track.al.id)
                                album.netId = track.al.id
                                album.qqId = ""
                                album.url = track.al.picUrl
                                music.album = album
                                AlbumManager.get.insert(music.album)
                                music.playlistId =
                                    PlaylistManager.get.setPlaylistId(result.playlist.id)
                                MusicManager.get.insert(music)
                            }
                            val playlist = PlaylistManager.get.getPlaylistById(
                                PlaylistManager.get.setPlaylistId(result.playlist.id)
                            )
                            if (playlist != null) {
                                view?.onSuccess(
                                    Constant.Music.Api.GET_PLAYLIST_DETAIL,
                                    false,
                                    playlist
                                )
                            } else {
                                view?.onEmptyStatusResponse()
                            }
                        } else {
                            view?.onEmptyStatusResponse()
                        }
                    }

                   // println(SingerManager.get.getSingers())
                }

                override fun onFailed(exception: String?) {
                    super.onFailed(exception)
                    view?.onEmptyStatusResponse()
                }
            })
    }

}