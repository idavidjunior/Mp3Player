cmake_minimum_required(VERSION 3.22)
project("fingerprint_jni" C CXX)

set(CMAKE_CXX_STANDARD 17)

set(CHROMAPRINT_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/chromaprint)
set(KISSFFT_SRC_DIR ${CMAKE_CURRENT_SOURCE_DIR}/kissfft)

# Chromaprint library sources (no FFmpeg-dependent files)
set(CHROMAPRINT_SOURCES
    ${CHROMAPRINT_SRC_DIR}/chromaprint.cpp
    ${CHROMAPRINT_SRC_DIR}/fft.cpp
    ${CHROMAPRINT_SRC_DIR}/fft_lib_kissfft.cpp
    ${CHROMAPRINT_SRC_DIR}/fingerprinter.cpp
    ${CHROMAPRINT_SRC_DIR}/fingerprinter_configuration.cpp
    ${CHROMAPRINT_SRC_DIR}/fingerprint_calculator.cpp
    ${CHROMAPRINT_SRC_DIR}/fingerprint_compressor.cpp
    ${CHROMAPRINT_SRC_DIR}/fingerprint_decompressor.cpp
    ${CHROMAPRINT_SRC_DIR}/fingerprint_matcher.cpp
    ${CHROMAPRINT_SRC_DIR}/chroma.cpp
    ${CHROMAPRINT_SRC_DIR}/chroma_filter.cpp
    ${CHROMAPRINT_SRC_DIR}/spectrum.cpp
    ${CHROMAPRINT_SRC_DIR}/image_builder.cpp
    ${CHROMAPRINT_SRC_DIR}/simhash.cpp
    ${CHROMAPRINT_SRC_DIR}/audio_processor.cpp
    ${CHROMAPRINT_SRC_DIR}/silence_remover.cpp
    ${CHROMAPRINT_SRC_DIR}/utils/base64.cpp
)

# KissFFT sources
set(KISSFFT_SOURCES
    ${KISSFFT_SRC_DIR}/kiss_fft.c
    ${KISSFFT_SRC_DIR}/kiss_fftnd.c
    ${KISSFFT_SRC_DIR}/kiss_fftndr.c
    ${KISSFFT_SRC_DIR}/kiss_fftr.c
    ${KISSFFT_SRC_DIR}/kfc.c
)

# JNI wrapper
set(JNI_WRAPPER ${CMAKE_CURRENT_SOURCE_DIR}/fingerprint_jni.cpp)

add_library(libchromaprint STATIC
    ${CHROMAPRINT_SOURCES}
    ${KISSFFT_SOURCES}
)

target_include_directories(libchromaprint
    PUBLIC
        ${CMAKE_CURRENT_SOURCE_DIR}
        ${CHROMAPRINT_SRC_DIR}
        ${CHROMAPRINT_SRC_DIR}/audio
        ${CHROMAPRINT_SRC_DIR}/utils
        ${KISSFFT_SRC_DIR}
)

target_compile_definitions(libchromaprint
    PUBLIC
        HAVE_CONFIG_H
        NDEBUG
        -D_SCL_SECURE_NO_WARNINGS
        -D_USE_MATH_DEFINES
        -D__STDC_LIMIT_MACROS
        -D__STDC_CONSTANT_MACROS
)

add_library(fingerprint_jni SHARED
    ${JNI_WRAPPER}
)

target_include_directories(fingerprint_jni
    PRIVATE
        ${CMAKE_CURRENT_SOURCE_DIR}
        ${CHROMAPRINT_SRC_DIR}
)

target_link_libraries(fingerprint_jni
    libchromaprint
    log
)
